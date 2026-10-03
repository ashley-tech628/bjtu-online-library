-- Empty starter schema derived from source mappings. No real user records.

CREATE DATABASE IF NOT EXISTS library_demo CHARACTER SET utf8mb4;

USE library_demo;

CREATE TABLE IF NOT EXISTS `auth_perm` (
  `id` VARCHAR(255) PRIMARY KEY,
  `code` VARCHAR(255) NULL,
  `name` VARCHAR(255) NULL,
  `is_valid` INT NULL,
  `sort_num` INT NULL,
  `create_time` VARCHAR(255) NULL,
  `update_time` VARCHAR(255) NULL,
  `create_user` VARCHAR(255) NULL,
  `update_user` VARCHAR(255) NULL
);

CREATE TABLE IF NOT EXISTS `auth_role` (
  `id` VARCHAR(255) PRIMARY KEY,
  `code` VARCHAR(255) NULL,
  `name` VARCHAR(255) NULL,
  `is_valid` INT NULL,
  `sort_num` INT NULL,
  `create_time` VARCHAR(255) NULL,
  `update_time` VARCHAR(255) NULL,
  `create_user` VARCHAR(255) NULL,
  `update_user` VARCHAR(255) NULL
);

CREATE TABLE IF NOT EXISTS `auth_role_perm_rel` (
  `id` VARCHAR(255) PRIMARY KEY,
  `role_id` VARCHAR(255) NULL,
  `perm_id` VARCHAR(255) NULL,
  `is_valid` INT NULL,
  `sort_num` INT NULL,
  `create_time` VARCHAR(255) NULL,
  `update_time` VARCHAR(255) NULL,
  `create_user` VARCHAR(255) NULL,
  `update_user` VARCHAR(255) NULL
);

CREATE TABLE IF NOT EXISTS `auth_user` (
  `id` VARCHAR(255) PRIMARY KEY,
  `username` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  `real_name` VARCHAR(255) NULL,
  `last_login_time` VARCHAR(255) NULL,
  `avatar_group_id` VARCHAR(255) NULL,
  `mobile` VARCHAR(255) NULL,
  `remark` VARCHAR(255) NULL,
  `is_valid` INT NULL,
  `sort_num` INT NULL,
  `create_time` VARCHAR(255) NULL,
  `update_time` VARCHAR(255) NULL,
  `create_user` VARCHAR(255) NULL,
  `update_user` VARCHAR(255) NULL
);

CREATE TABLE IF NOT EXISTS `auth_user_role_rel` (
  `id` VARCHAR(255) PRIMARY KEY,
  `user_id` VARCHAR(255) NULL,
  `role_id` VARCHAR(255) NULL,
  `is_valid` INT NULL,
  `sort_num` INT NULL,
  `create_time` VARCHAR(255) NULL,
  `update_time` VARCHAR(255) NULL,
  `create_user` VARCHAR(255) NULL,
  `update_user` VARCHAR(255) NULL
);

CREATE TABLE IF NOT EXISTS `basic_file` (
  `id` VARCHAR(255) PRIMARY KEY,
  `from_type` VARCHAR(255) NULL,
  `group_id` VARCHAR(255) NULL,
  `name` VARCHAR(255) NULL,
  `ext_name` VARCHAR(255) NULL,
  `content_type` VARCHAR(255) NULL,
  `size` VARCHAR(255) NULL,
  `path` VARCHAR(255) NULL,
  `is_valid` INT NULL,
  `sort_num` INT NULL,
  `create_time` VARCHAR(255) NULL,
  `update_time` VARCHAR(255) NULL,
  `create_user` VARCHAR(255) NULL,
  `update_user` VARCHAR(255) NULL
);

CREATE TABLE IF NOT EXISTS `book_library` (
  `id` VARCHAR(255) PRIMARY KEY,
  `create_user` VARCHAR(255) NULL,
  `update_user` VARCHAR(255) NULL,
  `type` VARCHAR(255) NULL,
  `title` VARCHAR(255) NULL,
  `author` VARCHAR(255) NULL,
  `publication_time` VARCHAR(255) NULL,
  `cover` VARCHAR(255) NULL,
  `description` TEXT NULL
);

CREATE TABLE IF NOT EXISTS `bookshelf` (
  `id` VARCHAR(255) PRIMARY KEY,
  `name` VARCHAR(255) NULL,
  `allbooks` VARCHAR(255) NULL
);

CREATE TABLE IF NOT EXISTS `house_region` (
  `id` VARCHAR(255) PRIMARY KEY,
  `create_time` VARCHAR(255) NULL,
  `update_time` VARCHAR(255) NULL,
  `create_user` VARCHAR(255) NULL,
  `update_user` VARCHAR(255) NULL,
  `code` VARCHAR(255) NULL,
  `name` VARCHAR(255) NULL,
  `short_name` VARCHAR(255) NULL,
  `land_area` INT NULL,
  `construction_area` INT NULL,
  `road_area` INT NULL,
  `green_area` INT NULL,
  `construction_num` INT NULL,
  `owner_status` VARCHAR(255) NULL,
  `estate_card_group_id` VARCHAR(255) NULL,
  `sort_num` INT NULL
);

CREATE TABLE IF NOT EXISTS `user_details` (
  `user_id` VARCHAR(255) NULL,
  `user_name` VARCHAR(255) NULL,
  `books` VARCHAR(255) NULL
);

INSERT INTO book_library (id,title,author,type,description) VALUES ('demo-001','A Guide to Library APIs','Demo Author','Technology','Synthetic catalog record for this public source release.');
