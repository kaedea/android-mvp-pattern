##Android MVP Pattern
[中文版](/doc/readme-cn.md)

This Project offers a `simple but clear` Android showcase project designed with `MVP Pattern (or MVP Framework)`, which comes to become a more and more important `design pattern` in Android application project. Besides, `MVP` used project is easy to changed into `MVVM`, the future of Android Project.

### What is MVP?
**Activity and Fragment** take most parts of Android Developing jobs. 

In traditional Android project, we often write business code and manipulate views directly inside Activity or Fragment. In this case, it is easy to write codes but the Activity or Fragment will become more and more complicated. It takes efforts to read and change. (We usually call this Android standard code style `MV Pattern`.)

![MVP结构](http://7xih5c.com1.z0.glb.clouddn.com/15-10-11/2114527.jpg "MVP结构")

With MVP pattern, the Activity will be just activity, which only does the job of "Find View", "Set Listener" and "React to the LifeCycle". The jobs of  UI Logic will be moved to IView, while the jobs of Business Logic will be moved to IPresenter. In this case, the Activity remains very simple and clear, so that it is read-friendly. And since the business logic is written in Presenter, it can be reused in other Activity easily.

By UML, it looks like
![简单MVP的UML](http://7xih5c.com1.z0.glb.clouddn.com/15-10-12/94032090.jpg "简单MVP的UML")

### Why MVP?

#### KISS Princeple
"Keep It Stupid Simple". MVP will make the Activity or Fragment much simpler, which means that it is easy to read and change.

#### Avoid Leak in Background Task
The code of business logic is moved to Presenter. So that all the background tasks (such as HTTP request, File operating) can be written here. We can remove the reference of Activity in  Presenter when onDestroy. Since we have separated this tasks from Activity, the Activity will not easily leak when it is onDestroy. 


### Project Structure
This Project is a sample project used in the following post in my Blog ([Android MVP模式 简单易懂的介绍方式](http://kaedea.com/2015/10/11/android-mvp-pattern)). The package structure is as the following table. 

| Package | Description | 
| :------- | :------ | 
| login | Simple MVP usage in Login |
| loginoptimized | Simple MVP usage in Login, avoid Activity leak |
| outteradapter | MVP usage in Adapter |
| eventbus | MVP usage with EventBus |
| fragments | MVP usage in ViewPager |

>Give MVP a try, tell your friends!

### Infomation

- Author：[Kaede Akatsuki](http://kaedea.com)
- Project：[Android-MVP-Pattern](https://github.com/kaedea/Android-MVP-Pattern)
- Archive：[Android MVP模式 简单易懂的介绍方式](http://kaedea.com/2015/10/11/android-mvp-pattern)


