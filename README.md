# everyday-todoList
项目前端地址： https://gitee.com/hulan2352495015/todolist
项目思想：
    
    每天正常工作的时候需要用到浏览器，所以基于浏览器的轻量级浏览器插件就很方便。
    设置todolist对于帮助每天完成任务很有帮助，一方面帮助提醒有什么事情要做，分析tasks的优先级，对于自己的task能够逐渐的得出量化的时间。对于自己的工作产出有量化的认知。
    对于每一个task有设置预设置完成时间， 当去做对应的task的时候有一个focues 时间，来判断自己对于task的预设值时间，可以帮助更合理的规划task时间，从而规划好每一天的时间。

详细设计需求：

    task设置时间，初始时间、例如 预设2h， 在某一个时刻开始focus了，那么开始2h的倒计时， 当觉得这次focus结束了，用户去手动关闭focus，倒计时结束， 将今天的这个task的剩余时间改为 本次剩余时间 - 本次focus时间。
    
    
    
    
