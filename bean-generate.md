spring容器的创建及刷新：
new AnnotationConfigApplicationContext(Class<?>... componentClasses) -> AbstractApplicationContext: refresh()

=================================================================================================================
==================================================beanFactory====================================================
=================================================================================================================

===========================================beanFactory的预处理工作================================================
1. prepareRefresh(): 刷新前的预处理
  1）initPropertySources()：初始化一些属性，子类（子容器）自定义个性化的属性设置方法；
  2）getEnvironment().validateRequiredProperties()：检验属性的合法性；
  3）earlyApplicationEvents：保存容器中的一些早期事件。
2. obtainFreshBeanFactory()：获取beanFactory
  1）refreshBeanFactory()：刷新beanFactory（DefaultListableBeanFactory，GenericApplicationContext构造器中new的），其实就是给beanFactory设置序列化id；
  2）将该beanFactory返回
3. prepareBeanFactory(beanFactory)：beanFactory的预准备工作
  1）设置beanFactory的类加载器和支持的表达式解析器，属性编辑注册器；
  2）addBeanPostProcessor：ApplicationContextAwareProcessor；
  3）设置自动装配时自动忽略的接口（ignoreDependencyInterface，由系统统一注入）：
    EnvironmentAware，
    EmbeddedValueResolverAware，
    ResourceLoaderAware，
    ApplicationEventPublisherAware，
    MessageSourceAware，
    ApplicationContextAware，
    ApplicationStartupAware；
  4）注册可解析依赖（registerResolvableDependency，由系统统一注入，可以在任何ioc组件中自动注入，如通过@Autowired注入）：
    BeanFactory，
    ResourceLoader，
    ApplicationEventPublisher，
    ApplicationContext；
  5）addBeanPostProcessor：ApplicationListenerDetector；
  6）添加编译时AspectJ的支持；
  7）向beanFactory注册组件（ioc中其他组件需要这些组件时，可以通过@Autowired直接注入）：
    environment：ConfigurableEnvironment
    systemProperties：Map<String, Object>
    systemEnvironment：Map<String, Object>
    applicationStartup：ApplicationStartup
4. postProcessBeanFactory(beanFactory)：beanFactory预准备工作完成后进行的后置处理
  1）子类通过重新该方法
===========================================beanFactory的预处理工作================================================
5. invokeBeanFactoryPostProcessors(beanFactory):执行BeanFactoryPostProcessor
  BeanFactoryPostProcessor：BeanFactory的后置处理器，在BeanFactory标准初始化之后（也就是上面的步骤1-4执行之后）执行
  BeanFactoryPostProcessor的两个主要接口：BeanFactoryPostProcessor，BeanDefinitionRegistryPostProcessor
  1）invokeBeanFactoryPostProcessors：执行BeanFactoryPostProcessor的方法
     ================================执行postProcessBeanDefinitionRegistry方法=========================
     1）priorityOrdered：获取实现BeanDefinitionRegistryPostProcessor接口的bean，
        过滤实现了PriorityOrdered接口的bean，排序并执行其postProcessBeanDefinitionRegistry方法
     2）Ordered：获取实现BeanDefinitionRegistryPostProcessor接口的bean，
        过滤实现Ordered接口的bean，排序并执行其postProcessBeanDefinitionRegistry方法
     3）normal：获取实现BeanDefinitionRegistryPostProcessor接口的bean，
        过滤已执行的bean，排序并执行其postProcessBeanDefinitionRegistry方法
     ================================执行postProcessBeanFactory方法==================================
     4）执行实现了PriorityOrdered接口的BeanFactoryPostProcessor的postProcessBeanFactory方法
     5）执行实现了Ordered接口的BeanFactoryPostProcessor的postProcessBeanFactory方法
     6）执行normal BeanFactoryPostProcessor的postProcessBeanFactory方法
     
=================================================================================================================
==============================================beanPostProcessor==================================================
=================================================================================================================
6. registerBeanPostProcessors(beanFactory)：注册beanPostProcessor，拦截bean的创建过程
  1）注册所有的BeanPostProcessor，含:
    BeanPostProcessor, 
    InstantiationAwareBeanPostProcessor, 
    MergedBeanDefinitionPostProcessor, 
    DestructionAwareBeanPostProcessor,
    SmartInstantiationAwareBeanPostProcessor。
    不同的接口类型执行的时机不同。
  2）获取所有的BeanPostProcessor
  3）注册PriorityOrdered接口的；
  4）注册Ordered接口的；
  5）注册没有实现上两个接口的；
  6）注册MergedBeanDefinitionPostProcessor
7. initMessageSource()：初始化MessageSource（国际化，消息绑定，消息解析）
  1）获取beanFactory
  2）判断是否存在beanName为messageSource的bean，如果存在直接使用，如果不存在则创建DelegatingMessageSource，并注入beanFactory
     MessageSource主要用于从国际化配置文件中取出key的值，并按照区域信息获取
8. initApplicationEventMulticaster()：初始化事件派发器
  1）获取beanFactory
  2）判断是否存在beanName为applicationEventMulticaster的bean，如果存在直接使用，如果不存在则创建SimpleApplicationEventMulticaster，并注入beanFactory
9. onRefresh()：留给子容器，当前类是空方法
10. registerListeners()：将容器中所有的listener注册到ApplicationEventMulticaster
  1）从容器中拿到所有的ApplicationListener组件
  2）将1）中的组件注册到事件派发器ApplicationEventMulticaster
  3）派发之前产生的事件进行派发
11. finishBeanFactoryInitialization(beanFactory)：初始化所有剩下的单实例bean
  1）beanFactory.preInstantiateSingletons()：初始化所有的单实例bean
    1）List<String> beanNames = new ArrayList<>(this.beanDefinitionNames)：获取所有beanDefinition的name
    2）遍历
    3）获取当前遍历bean的RootBeanDefinition
    4）如果是单实例，非懒加载，非抽象
      1）如果是FactoryBean，调用FactoryObject的getObject方法
      2）如果不是FactoryBean，
        1）调用getBean(beanName)方法获取
        2）调用doGetBean()
        3）先从singletonObjects缓存中保存的单实例bean，如果能获取到说明这个bean之前被创建过（所有被创建过的单例bean都会被缓存起来）
           如果没有获取到，则开始bean的创建流程
        4）创建bean的流程：
           1）标记当前bean已被创建
           2）获取bean的beanDefinition
           3）获取当前bean所依赖的其他bean（dependsOn），如果参在依赖bean，则递归调用getBean(beanName)方法进行获取
           4）【启动单实例的创建过程】
              getSigleton --> ObjectFactory.getObject() --> createBean(beanName, mbd, args)
              1）resolveBeforeInstantiation(beanName, mdbToUse)：让BeanPostProcessor先拦截返回代理对象
                 提前执行InstantiationAwarePostProcessor（bean创建之前执行）
                 先执行postProcessorsBeforeInstantiation方法
                 如果上面的方法有返回值，则再执行postProcessorsAfterInstantiation方法
              2）如果1）有返回值，则直接将结果作为代理对象返回，如果没有返回值，则执行3）
              3）doCreateBean(beanName, mbdToUse, args):创建bean
                1）创建bean实例，只是创建实例，没有赋值，空空如也：createBeanInstance(beanName, mbdToUse, args)
                   使用对应的工厂方法或者构造器创建出bean实例
                2）applyMergedBeanDefinitionPostProcessor(mbd, beanType, beanName)
                   调用MergedBeanDefinitionPostProcessor的postProcessorMergedBeanDefinition方法
                3）populateBean：给bean的属性进行赋值
                  1）赋值之前：调用InstantiationAwareBeanPostProcessor的postProcessAfterInstantiation方法
                  2）执行InstantiationAwareBeanPostProcessor的postProcessPropertyValues方法
                  3）通过applyPropertyValues(beanName, mbd, bw, pvs)调用setter方法对bean的属性进行赋值
                4）bean初始化：initializeBean(beanName, exposedObject, mdb)
                  1）invokeAwareMethods(beanName, bean)执行aware接口的方法
                     BeanNameAware, BeanClassLoaderAware, BeanFactoryAware
                  2）调用applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName)
                     执行BeanPostProcessor的postProcessBeforeInitialization方法
                  3）执行初始化方法：invokeInitMethods(beanName, wrappedBean, mbd)，回调自定义的初始化方法
                  4）调用applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName)
                     执行BeanPostProcessor的postProcessAfterInitialization方法
                5）注册bean的销毁方法：registerDisposableBeanIfNessary
           5）将创建好的单实例bean缓存到singletonObjects中 
       所有bean创建完成之后，会检查bean是否实现了SmartInitializingSigleton接口，如果是，则调用对应的afterSingletonsInstantiated方法         
12. finishRefresh()：完成BeanFactory的初始化创建工作，IOC容器创建完成
  1）initLifecycleProcessor()：初始化生命周期相关的后置处理器
  2）getLifecycleProcessor().onRefresh()：回调生命周期的onRefresh方法
  3）publishEvent(new ContextRefreshedEvent(this))：发布容器刷新完成事件

  
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    