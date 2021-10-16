#spring
##1. xml context

##2. anno context
###2.1 @Configuration & @Bean
（1）@Bean默认方法名是bean的id，如果@Bean中指定了bean的id，则使用@Bean中指定的id
（2）@Configuration继承@Component，所以也会被注册到ioc
（3）传入AnnotationConfigApplicationContext的配置类可以不加@Configuration注解，默认会被加入到ioc中
###2.2 @ComponentScan
（1）@ComponentScan如果不设置value及其alias，则默认会扫描注解所在类的所属路径及其子路径
（2）@ComponentScan只会扫描@Controller, @Service，@Repository, @Component
（3）@ComponentScan可以指定includeFilters和excludeFilters，其中FilterType可以按照注解，指定类型，ASPECTJ规则，正则和自定义进行过滤
（4）可以通过实现TypeFilter来自定义过滤条件，返回true表示将该类加入到ioc，反之亦然；参考MyTypeFilter
###2.2 scope
（1）单例
（2）protoype
###2.3 懒加载@Lazy

###2.4 按条件加载bean
  @Conditional
  
###2.5 spring给ioc注册组件
（1）适合自己创建的类注册到ioc：componentScan + 特定注解（@controller, @Service, @Repository, @component）
（2）适合将第三方里面的组件注册到ioc：@Configuration + @Bean
（3）批量导入：@Import
     1）直接在@Import注解内编写要注入的类数组
     2）ImportSelector：实现ImportSelector接口的类写到@Import注解内
     3）ImportBeanDefinitionRegistrar
（4）使用Spring提供的FactoryBean
  默认获取到的是FactoryBean的getObject返回的对象bean，如果要获取FactoryBean本身，则需要在beanName前面加&
  
  
###2.6 bean life cycle
  bean的创建 ---> 初始化 ---> bean的销毁
  我们可以自定义bean的初始化的销毁方法
  1）在@Bean注解中指定初始化（对象创建完成，并赋值完成后执行）和销毁方法（容器关闭时执行），
     但在prototype中，初始化发生在调用getBean方法时进行，而且销毁方法无效
  2）通过让Bean实现InitializingBean接口，并实现afterPropertiesSet方法来定义初始化逻辑
     通过让Bean实现DisposableBean接口，并实现destroy方法来定义销毁逻辑
  3）使用JSR250注解
     @PostConstruct: 初始化逻辑
     @PreDestroy: 销毁逻辑
  4）使用BeanPostProcessor:
    在bean初始化前后进行一些处理工作
    1）-3）是针对某个特定的bean进行的初始化和销毁工作，4）是针对所有加入ioc的bean起作用
    原理：
    AbstractAutowireCapableBeanFactory:       
   
      populateBean() //给bean的属性进行赋值
      initializeBean(){//初始化，包含以下三步骤
        applyBeanPostProcessorBeforeInitialization() //可以多个，进行遍历
        invokeInitMethods()
        applyBeanPostProcessorAfterInitialization()  //可以多个，进行遍历
      }
    
###2.7 BeanPostProcessor的使用
（1）生命周期注解@PostConstruct, @PreDestroy方法的调用
（2）Aware的处理
（3）@Autowire注解处理
（4）@Async注解处理
（5）Validate参数校验
...    
    
###2.8. 属性赋值
（1）使用@Value进行赋值:
    1）使用基本数值
    2）使用SpEL，#{}
    3）使用环境变量中的值，${}
    配置文件的引入方式：@PropertiesSource
（2）自动装配：@Autowired
    1）优先按照类型从容器中找到对应的组件，找到了就采用反射机制进行赋值
    2）如果同一类型的组件有多个，那么按照属性名作为id进行优先匹配，也可以使用@Qualifier指定id
    3）如果没有找到对应的组件，则报错，也可以通过@Autowired指定required为false 
    4）使用注解@Primary，可以让spring装配时默认使用带有@Primary注解的组件，@Qualifier优先级高于@Primary
    5）@Autowired可以标注在属性，方法（setter方法）和构造器上，或者方法和构造器的入参上；
    如果标注在属性，方法上，spring默认调用无参构造器进行对象创建，然后进行属性赋值；
    如果标注在构造器上，那么就是调用对应的有参构造器进行对象创建；
    如果标注在属性上，不需要对属性构建setter方法，因为spring会直接通过反射进行属性赋值
    如果组件只有一个有参构造器，那么该构造器上的@Autowired可以省略（@Bean注解的方法入参也一样）

（3）使用@Resource(JSR250)和@Inject(JSR330)
（4）通过实现XXXAware接口将spring底层组件注入自定义bean中
（5）通过@Profile可以根据当前的环境，动态的激活和切换组件（开发环境，测试环境，生产环境...）
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
