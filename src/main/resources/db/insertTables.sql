# use todolist;
# -- 插入话题表INSERT INTO table_name ( field1, field2,...fieldN )
# --                        VALUES
# --                        ( value1, value2,...valueN );
#     INSERT INTO topic
#     (topic_id, user_id, topicName, finished)
#     values
#     (1, 1, "准备面试", 0);
#
# -- 插入任务表
# INSERT INTO task
# (topic_id, taskName, defaultTime, finished)
# values
# (2, "看源码", "30", 0);
# INSERT INTO task
# (topic_id, taskName, defaultTime, finished)
# values
# (3, "看电影", "50", 0);
# INSERT INTO task
# (topic_id, taskName, defaultTime, finished)
# values
# (3, "举哑铃", "10", 0);
# INSERT INTO task
# (topic_id, taskName, defaultTime, finished)
# values
# (7, "玩游戏", "30", 0);
# INSERT INTO task
# (topic_id, taskName, defaultTime, finished)
# values
# (7, "冥想", "20", 0);
# INSERT INTO task
# (topic_id, taskName, defaultTime, finished)
# values
# (1, "复习不熟悉的数据库问题", "30mins", 0);
# INSERT INTO task
# (topic_id, taskName, defaultTime, finished)
# values
# (1, "复习不熟悉的Java问题", "30mins", 0);
--     联表查询测试
# use todolist;
# SELECT top.topic_id, top.topicName, top.finished, tas.task_id, tas.taskName, tas.defaultTime, tas.finished from topic top join task tas;
