# spi-framework
simple spi framework implemented by java

## version 1.0

### 原理
提供既定的接口，让用户在该接口的基础上自定义用户接口，框架通过反射来拿到实现某个用户接口的一组实现，使用代理，通过接口中的condition方法来判定改实现是否可执行，最终达到为接口寻找服务实现类的目的。

### 使用方式

1. 自定义用户接口并实现SpiBase接口(例:FoodSpi extends SpiBase)
2. 实现自定义接口，对服务实现类添加注解@BizSpi(例:Apple implements FoodSpi, Watermelon FoodSpi)
    - 若不使用以下功能，实现类中SpiConfig可以返回null
    - 若某组实现类互斥，即只允许有一个满足条件的实现类执行，设置SpiConfig的属性mutex为true，否则为false
    - 若要设置某组实现类的优先级，设置SpiConfig的属性priority(数值，越大优先级越高)，满足条件的实现类优先级越高越先被执行
3. 注入方式，为用户自定义接口的注入提供了工厂，使用方式如下：
    ```
    <!--扫描spi框架 自动注入实现类-->
    <context:component-scan base-package="org.cuner.spi.framework"/>
    
    <bean id="foodSpi" class="com.cuner.spi.framework.SpiProviderFactory">
        <property name="targetClass">"xxx.xxx.xxx.FoodSpi"</property>           
    </bean>
    ```
    
PS:实际用例请看测试用例test
