## 📚 项目介绍
这个项目是要做一个类似任务列表的功能，名字叫ToDoList。

1. 用户用这个软件来记录每天要干什么，同时这个事情预计要干多长时间。（记录信息）例如： 学习HTTP协议  30 mins
   我想法是可以有一个大的话题，然后在大话题之下要做相关的一些事情
   比如：
   
    （1）找工作（话题 ）  
   找岗位 30mins、改简历15mins、投简历10mins、准备面试 1h（任务）

    （2）学编程（话题 ）  
    学习异常处理 30mins、学习web接口开发 15mins（任务）

3. 每个事情后面有一个按钮，用户可以在做事情的时候，点一下，然后这件事情的预计时间开始减少，用来记录干了多长时间，剩下多长时间了。

比如： 找岗位 30mins （开始按钮）  --  5mins后  找岗位 25mins （暂停按钮）
进行中的任务，用户可以暂停任务。

如果预计时间结束了， 比如预计30mins， 倒计时结束了，那么这个任务就算完成了；当列表中所有任务都完成后， 该话题放进已完成列表。

已完成列表跟todolist很像， 也有一个话题，和对应的任务， 这个已完成列表中的任务是从todolist那边执行完的任务列表，所以这边的任务列表不会有后面的按钮。
## ToDoList 前端地址：https://gitee.com/hulan2352495015/todolist

## ToDoList 项目后端开发
> 核心技术栈：JDK1.8、SpringBoot2.7.7、 MyBatis2.3.0、 MySQL5.7.9

### 已实现模块
    用户注册接口开发
    
    用户登录接口开发
      
    话题接口开发

    任务接口开发
    
### 待做

    消息推送功能（将未完成的任务在第二天用户登陆时推送给用户）

    用户登出
   
    敏感资源的访问控制

    系统前后端联合调试

    服务部署上线

### 正在做模块 Doing。。。
    Swagger接口文档

### 遇到的问题
1. 话题数据提交上来如何找到该用户的信息, 通过什么来将这个请求的用户和这个请求的数据绑定在一起

目前的解决方案, 应该是前端通过将登录成功获取的用户id或者Token一起来发送这个操作话题的接口请求
接口请求收到http请求之中,body带有请求参数,用于和数据库交互, 另外应该是请求的头部带有token或者用户ID,解析之后获取到对应的用户,
这样就获取到了这个话题属于哪一个用户了.

2. 前端请求的时候带上了用来唯一识别用户的ID， 这时候后端用什么来接收这个ID

3. 后端这边如何实时获取用户身份？

    解决方案：
>1. 请求头中的Authorization字段：浏览器在发出请求时，会在请求头中包含有关用户身份的信息（如用户名、密码等）。
>2. Cookie：服务器可以将用户身份信息存储在客户端的Cookie中，在服务器接收到请求时，可以从Cookie中获取到用户身份信息。
>3. 请求参数：客户端可以在发出请求时，在请求参数中包含用户身份信息，服务器可以从请求参数中获取用户身份信息。
>4. 路由参数：客户端可以在发出请求时，在路由参数中包含用户身份信息，服务器可以从路由参数中获取用户身份信息。

4. 跨域请求问题 （已解决）

       解决方案：
       1. https://blog.csdn.net/wangmx1993328/article/details/88524163
        这篇文章讲了7种解决方案，我选择了方式5：重写 WebMvcConfigurer接口(全局跨域) 
        重写了 addCorsMappings 方法设置跨域映射。

5. mybatis 查询结果对象数据不完整（已解决）
      ![img.png](img.png)
      
      ![img_1.png](img_1.png)
      
      ![img_2.png](img_2.png)

      ![img_3.png](img_3.png)
      用这个mapper查询的user对象id和phoneNumber都是null，但是数据库中数据是完整的。

      解决方案：
       因为没有实现实体和关系的映射，而且数据库表属性和对象属性不一样，导致mybatis查询结果为null；

6. 前端需要返回的数据为![img_5.png](img_5.png)，除过前两个ID，如何将查询出来的数据进行处理，
   只给前端返回后两条数据的对象列表。（以解决）

    解决方案： 用Lombok的builder注解 实现对象映射。

7. web接口-根据用户Id查询所有话题，速度慢，待优化 
      
     解决方案：利用sql联表查询，将数据一次性全部查出来，
      这样就不用再service层用一个循环去遍历查询sql，显著提升接口返回速度。
8. ![img_6.png](img_6.png) 出现一场，方法不支持
     
    解决方案：![img_7.png](img_7.png) https://www.jianshu.com/p/d545901dd8d6

9. lombok 的@builder 来新建一个对象和用构造器来新建一个对象分别优缺点与选择（未解决）