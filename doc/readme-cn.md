## Android MVP 模式
这个项目是一个简单的Android MVP项目，用于展示MVP结构的基本写法。上面的表格是这个演示项目代码的结构。

### 基本信息

- 作者：[Kaede Akatsuki](http://kaedea.com)
- 项目：[Android-MVP-Pattern](https://github.com/kaedea/Android-MVP-Pattern)
- 日志：[Android MVP模式 简单易懂的介绍方式](http://kaedea.com/2015/10/11/android-mvp-pattern)


## MVP模式
在Android项目中，Activity和Fragment占据了大部分的开发工作。如果有一种设计模式（或者说代码结构）专门是为优化Activity和Fragment的代码而产生的，你说这种模式重要不？这就是MVP设计模式。

按照MVC的分层，Activity和Fragment（后面只说Activity）应该属于View层，用于展示UI界面，以及接收用户的输入，此外还要承担一些生命周期的工作。Activity是在Android开发中充当非常重要的角色，特别是TA的生命周期的功能，所以开发的时候我们经常把一些业务逻辑直接写在Activity里面，这非常直观方便，代价就是Activity会越来越臃肿，超过1000行代码是常有的事，而且如果是一些可以通用的业务逻辑（比如用户登录），写在具体的Activity里就意味着这个逻辑不能复用了。如果有进行代码重构经验的人，看到1000+行的类肯定会有所顾虑。因此，Activity不仅承担了View的角色，还承担了一部分的Controller角色，这样一来V和C就耦合在一起了，虽然这样写方便，但是如果业务调整的话，要维护起来就难了，而且在一个臃肿的Activity类查找业务逻辑的代码也会非常蛋疼，所以看起来有必要在Activity中，把View和Controller抽离开来，而这就是MVP模式的工作了。

![MVP结构](http://7xih5c.com1.z0.glb.clouddn.com/15-10-11/2114527.jpg "MVP结构")

MVP模式的核心思想
>**MVP把Activity中的UI逻辑抽象成View接口，把业务逻辑抽象成Presenter接口，Model类还是原来的Model**。

这就是MVP模式，现在这样的话，Activity的工作的简单了，只用来响应生命周期，其他工作都丢到Presenter中去完成。从上图可以看出，Presenter是Model和View之间的桥梁，为了让结构变得更加简单，View并不能直接对Model进行操作，这也是MVP与MVC最大的不同之处。

## MVP模式的作用
MVP的好处都有啥，谁说对了就给他…

- 分离了视图逻辑和业务逻辑，降低了耦合
- Activity只处理生命周期的任务，代码变得更加简洁
- 视图逻辑和业务逻辑分别抽象到了View和Presenter的接口中去，提高代码的可阅读性
- 把业务逻辑抽到Presenter中去，避免后台线程引用着Activity导致Activity的资源无法被系统回收从而引起内存泄露和OOM
- Presenter被抽象成接口，可以有多种具体的实现，所以方便进行单元测试

说了这么多，没看懂？好吧，我自己都没看懂自己写的，我们还是直接看代码吧。

## MVP模式的使用
![简单MVP的UML](http://7xih5c.com1.z0.glb.clouddn.com/15-10-12/94032090.jpg "简单MVP的UML")

上面一张简单的MVP模式的UML图，从图中可以看出，使用MVP，至少需要经历以下步骤：

 1. 创建IPresenter接口，把所有业务逻辑的接口都放在这里，并创建它的实现PresenterCompl（在这里可以方便地查看业务功能，由于接口可以有多种实现所以也方便写单元测试）
 2. 创建IView接口，把所有视图逻辑的接口都放在这里，其实现类是当前的Activity/Fragment
 3. 由UML图可以看出，Activity里包含了一个IPresenter，而PresenterCompl里又包含了一个IView并且依赖了Model。Activity里只保留对IPresenter的调用，其它工作全部留到PresenterCompl中实现
 4. Model并不是必须有的，但是一定会有View和Presenter

通过上面的介绍，MVP的主要特点就是把Activity里的许多逻辑都抽离到View和Presenter接口中去，并由具体的实现类来完成。这种写法多了许多IView和IPresenter的接口，在某种程度上加大了开发的工作量，刚开始使用MVP的小伙伴可能会觉得这种写法比较别扭，而且难以记住。其实一开始想太多也没有什么卵用，只要在具体项目中多写几次，就能熟悉MVP模式的写法，理解TA的意图，以及享♂受其带来的好处。

扯了这么多，但是好像并没有什么卵用，毕竟
>Talk is cheap, let me show you the code!

更详细的信息请到[Android MVP模式 简单易懂的介绍方式](http://kaedea.com/2015/10/11/android-mvp-pattern)围观。

