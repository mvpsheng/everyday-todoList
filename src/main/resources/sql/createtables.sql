# use todolist;
# show databases;
#
# create table if not exists `user` (
#     `user_id` bigint(20) auto_increment,
#     `username` varchar(32) not null,
#     `phone_number` varchar(11) not null,
#     `password` varchar(32) not null,
#     primary key (`user_id`)
# );
# desc user;
# use todolist;
# create table if not exists `topic` (
#      `topic_id` bigint(20) auto_increment,
#      `user_id` bigint(20) not null,
#      `topicName` varchar(32) not null,
#      `finished` tinyint(1) not null,
#      primary key (`topic_id`),
#      foreign key (`user_id`) references user(`user_id`)
# );
# desc topic;
# 话题实体
#     属性：
#     话题ID（主键）Long
#     用户ID（外键）Long
#     话题名称 String
#     话题完成 boolean
# use todolist;
# create table if not exists `task` (
#       `task_id` bigint(20) auto_increment,
#       `topic_id` bigint(20) not null,
#       `taskName` varchar(32) not null,
#       `defaultTime` varchar(32),
#       `finished` tinyint(1) not null,
#       primary key (`task_id`),
#       foreign key (`topic_id`) references topic(`topic_id`)
# );
# desc task;