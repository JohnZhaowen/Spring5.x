#spring
##1. xml context

##2. anno context
###2.1 @Configuration & @Bean
（1）@Bean默认方法名是bean的id，如果@Bean中指定了bean的id，则使用@Bean中指定的id
（2）@Configuration继承@Component，所以也会被注册到ioc
###2.2 @ComponentScan
（1）@ComponentScan如果不设置value及其alias，则默认会扫描注解所在类的所属路径及其子路径
（2）@ComponentScan只会扫描@Controller, @Service，@Repository, @Component
（3）@ComponentScan可以指定includeFilters和excludeFilters，其中FilterType可以按照注解，指定类型，ASPECTJ规则，正则和自定义进行过滤
（4）可以通过实现TypeFilter来自定义过滤条件，返回true表示将该类加入到ioc，反之亦然；参考MyTypeFilter
