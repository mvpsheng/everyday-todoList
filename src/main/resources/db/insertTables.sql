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
# (1, "看牛客面经", "10mins", 0);
# INSERT INTO task
# (topic_id, taskName, defaultTime, finished)
# values
# (1, "复习不熟悉的数据库问题", "30mins", 0);
# INSERT INTO task
# (topic_id, taskName, defaultTime, finished)
# values
# (1, "复习不熟悉的Java问题", "30mins", 0);