USE userbase;
DROP TABLE IF EXISTS oauth_twitter_token;
DROP TABLE IF EXISTS paypal_onetime_status;
DROP TABLE IF EXISTS myfeeds;
DROP TABLE IF EXISTS direct_messages;
DROP TABLE IF EXISTS follows;
DROP TABLE IF EXISTS thread_follows;
DROP TABLE IF EXISTS user_thread_comments;
DROP TABLE IF EXISTS thread_comments;
DROP TABLE IF EXISTS user_threads;
DROP TABLE IF EXISTS thread_categories;
DROP TABLE IF EXISTS threads;
DROP TABLE IF EXISTS api_categories;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS api_review_rates;
DROP TABLE IF EXISTS update_data;
DROP TABLE IF EXISTS api_reviews;
DROP TABLE IF EXISTS api_use_logs;
DROP TABLE IF EXISTS api_projects;
DROP TABLE IF EXISTS rate_limits;
DROP TABLE IF EXISTS user_apis;
DROP TABLE IF EXISTS user_reports;
DROP TABLE IF EXISTS api_details;
DROP TABLE IF EXISTS apis;
DROP TABLE IF EXISTS licenses;
DROP TABLE IF EXISTS organization_users;
DROP TABLE IF EXISTS user_projects;
DROP TABLE IF EXISTS user_credits;
DROP TABLE IF EXISTS user_activate;
DROP TABLE IF EXISTS user_attributes;
DROP TABLE IF EXISTS user_info;
DROP TABLE IF EXISTS ClientDetails;
DROP TABLE IF EXISTS oauth_approvals;
DROP TABLE IF EXISTS oauth_code;
DROP TABLE IF EXISTS oauth_refresh_token;
DROP TABLE IF EXISTS oauth_access_token;
DROP TABLE IF EXISTS oauth_client_token;
DROP TABLE IF EXISTS oauth_client_details;
DROP TABLE IF EXISTS UserConnection;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;




-- create table
--  user
CREATE TABLE users (
  id                    BIGINT UNSIGNED NOT NULL PRIMARY KEY,
  username              VARCHAR(255) NOT NULL UNIQUE,
  password              VARCHAR(255) NOT NULL,
  activated             TINYINT NOT NULL DEFAULT 1,
  enabled               TINYINT NOT NULL DEFAULT 1,
  accountNonExpired     TINYINT NOT NULL DEFAULT 1,
  credentialsNonExpired TINYINT NOT NULL DEFAULT 1,
  accountNonLocked      TINYINT NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE roles (
  id    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  role  VARCHAR(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_roles (
  userId  BIGINT UNSIGNED NOT NULL,
  roleId  INT NOT NULL,
  KEY user (userId),
  KEY role (roleId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE UserConnection (
  userId varchar(255) not null,
  providerId varchar(255) not null,
  providerUserId varchar(255),
  rank int not null,
  displayName varchar(255),
  profileUrl varchar(512),
  imageUrl varchar(512),
  accessToken varchar(255) not null,
  secret varchar(255),
  refreshToken varchar(255),
  expireTime bigint,
  primary key (userId, providerId, providerUserId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE UNIQUE INDEX userconnectionrank on UserConnection(userId, providerId, rank);



--  oauth FIXME
create table oauth_client_details (
  client_id               VARCHAR(255) PRIMARY KEY,
  resource_ids            VARCHAR(255),
  client_secret           VARCHAR(255),
  scope                   VARCHAR(255),
  authorized_grant_types  VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities             VARCHAR(255),
  access_token_validity   INTEGER,
  refresh_token_validity  INTEGER,
  additional_information  VARCHAR(4096),
  autoapprove             VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table oauth_client_token (
  token_id          VARCHAR(255),
  token             BLOB,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name         VARCHAR(255),
  client_id         VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table oauth_access_token (
  token_id          VARCHAR(255),
  token             BLOB,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name         VARCHAR(255),
  client_id         VARCHAR(255),
  authentication    BLOB,
  refresh_token     VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table oauth_refresh_token (
  token_id        VARCHAR(255),
  token           BLOB,
  authentication  BLOB
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table oauth_code (
  code            VARCHAR(255),
  authentication  BLOB
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table oauth_approvals (
  userId          VARCHAR(255),
  clientId        VARCHAR(255),
  scope           VARCHAR(255),
  status          VARCHAR(10),
  expiresAt       TIMESTAMP,
  lastModifiedAt  TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table ClientDetails (
  appId                   VARCHAR(255) PRIMARY KEY,
  resourceIds             VARCHAR(255),
  appSecret               VARCHAR(255),
  scope                   VARCHAR(255),
  grantTypes              VARCHAR(255),
  redirectUrl             VARCHAR(255),
  authorities             VARCHAR(255),
  access_token_validity   INTEGER,
  refresh_token_validity  INTEGER,
  additionalInformation   VARCHAR(4096),
  autoApproveScopes       VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




--  user/developer info
CREATE TABLE user_info (
  userId          BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username        VARCHAR(255) NOT NULL UNIQUE,
  displayname     VARCHAR(32) NOT NULL UNIQUE,
  thumbnail       TINYINT NOT NULL DEFAULT 0,
  firstname       VARCHAR(16),
  familyname      VARCHAR(16),
--  middlename      VARCHAR(16),
--  gender          TINYINT,
--  age             TINYINT,
  homepage        VARCHAR(255),
  affiliation     VARCHAR(64),
--  country         VARCHAR(32),
  description     VARCHAR(255),
  open            TINYINT NOT NULL DEFAULT 0,
  isOrganization  TINYINT NOT NULL DEFAULT 0,
  registeredAt    TIMESTAMP NOT NULL,
  lastLoginedAt   TIMESTAMP NOT NULL,
  updatedAt       TIMESTAMP NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=6;

CREATE TABLE user_attributes (
  userId        BIGINT UNSIGNED NOT NULL PRIMARY KEY,
  numFollows    BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numFollowers  BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numDeveloped  BIGINT UNSIGNED NOT NULL DEFAULT 0,
  FOREIGN KEY (userId)
    REFERENCES user_info (userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_activate (
  username      VARCHAR(255) NOT NULL PRIMARY KEY,
  userId        BIGINT UNSIGNED,
  password      VARCHAR(255) NOT NULL,
  confirmation  VARCHAR(255) NOT NULL,
  enabled       TINYINT NOT NULL DEFAULT 0,
  registeredAt  TIMESTAMP NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table user_credits (
  userId          BIGINT UNSIGNED NOT NULL PRIMARY KEY,
  restFreeCredit  BIGINT NOT NULL DEFAULT 0,
  restPaidCredit  BIGINT NOT NULL DEFAULT 0,
  earnedCredit    BIGINT NOT NULL DEFAULT 0,
  paypalId        VARCHAR(255),
  FOREIGN KEY (userId)
    REFERENCES user_info (userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table user_projects (
  projectId    BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userId       BIGINT UNSIGNED NOT NULL,
  title        VARCHAR(64) NOT NULL,
  description  VARCHAR(128) NOT NULL,
  registeredAt TIMESTAMP NOT NULL,
  open         TINYINT NOT NULL DEFAULT 0,
  FOREIGN KEY (userId)
    REFERENCES user_info (userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

create table organization_users (
  orgId        BIGINT UNSIGNED NOT NULL,
  userId       BIGINT UNSIGNED NOT NULL,
  registeredAt TIMESTAMP NOT NULL,
  root         TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (orgId, userId),
  FOREIGN KEY (orgId)
    REFERENCES user_info (userId),
  FOREIGN KEY (userId)
    REFERENCES user_info (userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




--  API data
create table licenses (
  licenseId   TINYINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  license     VARCHAR(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table apis (
  apiId         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title         VARCHAR(64) NOT NULL,
  userId        BIGINT UNSIGNED NOT NULL,
  devId         BIGINT UNSIGNED NOT NULL,
  developer     VARCHAR(64) NOT NULL,
  anonymous     TINYINT NOT NULL DEFAULT 0,
  thumbnail     TINYINT NOT NULL DEFAULT 0,
  stable        TINYINT NOT NULL DEFAULT 0,
  enabled       TINYINT NOT NULL DEFAULT 1,
  ready         TINYINT NOT NULL DEFAULT 1,
  open          TINYINT NOT NULL DEFAULT 1,
  exclusive     TINYINT NOT NULL DEFAULT 0,
-- sort fields
  numCalled     BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numRegistered BIGINT UNSIGNED NOT NULL DEFAULT 0,
  rate          TINYINT NOT NULL DEFAULT 0,
  numReview     BIGINT UNSIGNED NOT NULL DEFAULT 0,
  rateNumReview FLOAT UNSIGNED NOT NULL DEFAULT 0,
  royalty       INTEGER UNSIGNED NOT NULL DEFAULT 0,
  loadLevel     INTEGER UNSIGNED NOT NULL DEFAULT 0,
  licenseId     TINYINT NOT NULL DEFAULT 1,
  commercial    TINYINT NOT NULL DEFAULT 1,
  registeredAt  TIMESTAMP NOT NULL,
  numUnethical  BIGINT UNSIGNED NOT NULL DEFAULT 0,
--  advertiseRate BIGINT UNSIGNED NOT NULL DEFAULT 0,
--  sale          TINYINT NOT NULL DEFAULT 0,
--  saleRoyalty   INTEGER UNSIGNED NOT NULL DEFAULT 0,
--  saleEndDateAt TIMESTAMP NOT NULL,
  FOREIGN KEY (userId)
    REFERENCES user_info (userId),
  FOREIGN KEY (devId)
    REFERENCES user_info (userId),
  FOREIGN KEY (licenseId)
    REFERENCES licenses (licenseId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=100;

create table api_details (
  apiId         BIGINT UNSIGNED NOT NULL PRIMARY KEY,
  description   VARCHAR(1024) NOT NULL,
  usages        VARCHAR(1024) NOT NULL,
  url           VARCHAR(255) NOT NULL,
  version       VARCHAR(16) NOT NULL,
  updateInfo    VARCHAR(1024) NOT NULL,
  endpoint      VARCHAR(255) NOT NULL,
  numTrial      BIGINT UNSIGNED NOT NULL DEFAULT 0,
-- sort fields
  aveCpuCost    INTEGER UNSIGNED NOT NULL DEFAULT 0,
  numCalledThis BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numCalledAll  BIGINT UNSIGNED NOT NULL DEFAULT 0,
  lastUpdatedAt TIMESTAMP NOT NULL,
  FOREIGN KEY (apiId)
    REFERENCES apis (apiId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table user_reports (
  apiId         BIGINT UNSIGNED NOT NULL,
  userId        BIGINT UNSIGNED NOT NULL,
  unethical     TINYINT NOT NULL DEFAULT 0,
  enabled       TINYINT NOT NULL DEFAULT 1,
  registeredAt  TIMESTAMP NOT NULL,
  PRIMARY KEY (apiId,userId),
  FOREIGN KEY (apiId)
    REFERENCES apis (apiId),
  FOREIGN KEY (userId)
    REFERENCES user_info (userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table user_apis (
  userId          BIGINT UNSIGNED NOT NULL,
  apiId           BIGINT UNSIGNED NOT NULL,
  numCalledMonth  BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numCalledTotal  BIGINT UNSIGNED NOT NULL DEFAULT 0,
  usedCreditMonth BIGINT NOT NULL DEFAULT 0,
  usedCreditTotal BIGINT NOT NULL DEFAULT 0,
  restTrial       BIGINT UNSIGNED NOT NULL DEFAULT 0,
  registeredAt    TIMESTAMP NOT NULL,
  enabled         TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (userId, apiId),
  FOREIGN KEY (userId)
    REFERENCES user_info (userId),
  FOREIGN KEY (apiId)
    REFERENCES apis (apiId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table rate_limits (
  userId          BIGINT UNSIGNED NOT NULL,
  apiId           BIGINT UNSIGNED NOT NULL,
  numCalled       BIGINT UNSIGNED NOT NULL DEFAULT 0,
  lastCalledAt    TIMESTAMP NOT NULL,
  PRIMARY KEY (userId, apiId),
  FOREIGN KEY (userId)
    REFERENCES user_info (userId)
--  FOREIGN KEY (apiId)
--    REFERENCES apis (apiId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table api_projects (
  projectId    BIGINT UNSIGNED NOT NULL,
  apiId        BIGINT UNSIGNED NOT NULL,
  registeredAt TIMESTAMP NOT NULL,
  PRIMARY KEY (projectId, apiId),
  FOREIGN KEY (projectId)
    REFERENCES user_projects (projectId),
  FOREIGN KEY (apiId)
    REFERENCES apis (apiId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table api_use_logs (
  logId        BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  projectId    BIGINT UNSIGNED NOT NULL,
  apiId        BIGINT UNSIGNED NOT NULL,
  userId       BIGINT UNSIGNED NOT NULL,
  accessDate   TIMESTAMP NOT NULL,
  finishDate   TIMESTAMP NOT NULL,
  processTime  BIGINT UNSIGNED NOT NULL DEFAULT 0,
  processFee   BIGINT UNSIGNED NOT NULL DEFAULT 0,
  royaltyFee   BIGINT UNSIGNED NOT NULL DEFAULT 0,
  success      TINYINT NOT NULL DEFAULT 1,
  paid         TINYINT NOT NULL DEFAULT 0,
  apitoreFree  TINYINT NOT NULL DEFAULT 0,
  donation     TINYINT NOT NULL DEFAULT 0,
  FOREIGN KEY (apiId)
    REFERENCES apis (apiId),
  FOREIGN KEY (userId)
    REFERENCES user_info (userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table api_reviews (
  reviewId      BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  apiId         BIGINT UNSIGNED NOT NULL,
  userId        BIGINT UNSIGNED NOT NULL,
  version       VARCHAR(64) NOT NULL,
  rate          TINYINT NOT NULL,
  description   VARCHAR(255) NOT NULL,
  registeredAt  TIMESTAMP NOT NULL,
  numGood       BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numNotGood    BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numUnethical  BIGINT UNSIGNED NOT NULL DEFAULT 0,
  enabled       TINYINT NOT NULL DEFAULT 1,
  UNIQUE (apiId,userId,version),
  FOREIGN KEY (userId)
    REFERENCES user_info (userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table update_data (
  id            TINYINT NOT NULL PRIMARY KEY,
  lastUpdatedAt TIMESTAMP NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table api_review_rates (
  apiId BIGINT UNSIGNED NOT NULL PRIMARY KEY,
-- this version
  numReviewThis     BIGINT UNSIGNED NOT NULL DEFAULT 0,
  rateThis          TINYINT NOT NULL DEFAULT 0,
  numFiveThis       BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numFourThis       BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numThreeThis      BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numTwoThis        BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numOneThis        BIGINT UNSIGNED NOT NULL DEFAULT 0,
  percentFiveThis   TINYINT NOT NULL DEFAULT 0,
  percentFourThis   TINYINT NOT NULL DEFAULT 0,
  percentThreeThis  TINYINT NOT NULL DEFAULT 0,
  percentTwoThis    TINYINT NOT NULL DEFAULT 0,
  percentOneThis    TINYINT NOT NULL DEFAULT 0,
-- all version
  numReviewAll      BIGINT UNSIGNED NOT NULL DEFAULT 0,
  rateAll           TINYINT NOT NULL DEFAULT 0,
  numFiveAll        BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numFourAll        BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numThreeAll       BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numTwoAll         BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numOneAll         BIGINT UNSIGNED NOT NULL DEFAULT 0,
  percentFiveAll    TINYINT NOT NULL DEFAULT 0,
  percentFourAll    TINYINT NOT NULL DEFAULT 0,
  percentThreeAll   TINYINT NOT NULL DEFAULT 0,
  percentTwoAll     TINYINT NOT NULL DEFAULT 0,
  percentOneAll     TINYINT NOT NULL DEFAULT 0,
-- setting
  FOREIGN KEY (apiId)
    REFERENCES api_details (apiId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




--   categories -> NoSQL in future
create table categories (
  categoryId  BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  category    VARCHAR(64) NOT NULL UNIQUE,
  visible     TINYINT NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=100;

--   api_categories -> NoSQL in future
create table api_categories (
  apiId       BIGINT UNSIGNED NOT NULL,
  categoryId  BIGINT UNSIGNED NOT NULL,
  locked      TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (apiId, categoryId),
  FOREIGN KEY (apiId)
    REFERENCES apis (apiId),
  FOREIGN KEY (apiId)
    REFERENCES api_details (apiId),
  FOREIGN KEY (categoryId)
    REFERENCES categories (categoryId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




--  communication
create table threads (
  threadId      BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title         VARCHAR(64) NOT NULL,
  askPrice      BIGINT UNSIGNED NOT NULL,
  userId        BIGINT UNSIGNED NOT NULL,
  registeredAt  TIMESTAMP NOT NULL,
  updatedAt     TIMESTAMP NOT NULL,
  open          TINYINT NOT NULL DEFAULT 1,
  enabled       TINYINT NOT NULL DEFAULT 1,
  numComment    BIGINT UNSIGNED NOT NULL DEFAULT 1,
  numWant       BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numMake       BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numGood       BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numNotGood    BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numUnethical  BIGINT UNSIGNED NOT NULL DEFAULT 0,
  FOREIGN KEY (userId)
    REFERENCES user_info (userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table thread_categories (
  threadId    BIGINT UNSIGNED NOT NULL,
  categoryId  BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (threadId, categoryId),
  FOREIGN KEY (threadId)
    REFERENCES threads (threadId),
  FOREIGN KEY (categoryId)
    REFERENCES categories (categoryId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table user_threads (
  threadId      BIGINT UNSIGNED NOT NULL,
  userId        BIGINT UNSIGNED NOT NULL,
  want          TINYINT NOT NULL DEFAULT 0,
  make          TINYINT NOT NULL DEFAULT 0,
  good          TINYINT NOT NULL DEFAULT 0,
  notGood       TINYINT NOT NULL DEFAULT 0,
  unethical     TINYINT NOT NULL DEFAULT 0,
  enabled       TINYINT NOT NULL DEFAULT 1,
  registeredAt  TIMESTAMP NOT NULL,
  PRIMARY KEY (threadId,userId),
  FOREIGN KEY (threadId)
    REFERENCES threads (threadId),
  FOREIGN KEY (userId)
    REFERENCES user_info (userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table thread_comments (
  commentId     BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  threadId      BIGINT UNSIGNED NOT NULL,
  userId        BIGINT UNSIGNED NOT NULL,
  parentId      BIGINT UNSIGNED NOT NULL,
  apiId         BIGINT UNSIGNED,
  askPrice      BIGINT UNSIGNED,
  description   VARCHAR(512) NOT NULL,
  registeredAt  TIMESTAMP NOT NULL,
  enabled       TINYINT NOT NULL DEFAULT 1,
  numGood       BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numNotGood    BIGINT UNSIGNED NOT NULL DEFAULT 0,
  numUnethical  BIGINT UNSIGNED NOT NULL DEFAULT 0,
  FOREIGN KEY (threadId)
    REFERENCES threads (threadId),
  FOREIGN KEY (userId)
    REFERENCES user_info (userId),
  FOREIGN KEY (apiId)
    REFERENCES apis (apiId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table user_thread_comments (
  commentId     BIGINT UNSIGNED NOT NULL,
  userId        BIGINT UNSIGNED NOT NULL,
  good          TINYINT NOT NULL DEFAULT 0,
  notGood       TINYINT NOT NULL DEFAULT 0,
  unethical     TINYINT NOT NULL DEFAULT 0,
  enabled       TINYINT NOT NULL DEFAULT 1,
  registeredAt  TIMESTAMP NOT NULL,
  PRIMARY KEY (commentId,userId),
  FOREIGN KEY (commentId)
    REFERENCES thread_comments (commentId),
  FOREIGN KEY (userId)
    REFERENCES user_info (userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table thread_follows (
  userId        BIGINT UNSIGNED NOT NULL,
  threadId      BIGINT UNSIGNED NOT NULL,
  updatedAt     TIMESTAMP NOT NULL,
  enabled       TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (userId,threadId),
  FOREIGN KEY (userId)
    REFERENCES user_info (userId),
  FOREIGN KEY (threadId)
    REFERENCES threads (threadId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table follows (
  fromId        BIGINT UNSIGNED NOT NULL,
  toId          BIGINT UNSIGNED NOT NULL,
  registeredAt  TIMESTAMP NOT NULL,
  blocked       TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (fromId,toId),
  FOREIGN KEY (fromId)
    REFERENCES user_info (userId),
  FOREIGN KEY (toId)
    REFERENCES user_info (userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table direct_messages (
  dmId          BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  fromId        BIGINT UNSIGNED NOT NULL,
  toId          BIGINT UNSIGNED NOT NULL,
  description   VARCHAR(255) NOT NULL,
  registeredAt  TIMESTAMP NOT NULL,
  enabled       TINYINT NOT NULL DEFAULT 1,
  FOREIGN KEY (fromId)
    REFERENCES user_info (userId),
  FOREIGN KEY (toId)
    REFERENCES user_info (userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




--  feed
create table myfeeds (
  feedId        BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  userId        BIGINT UNSIGNED NOT NULL,
  description   VARCHAR(255) NOT NULL,
  registeredAt  TIMESTAMP NOT NULL,
  FOREIGN KEY (userId)
    REFERENCES user_info (userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




--  cashing
create table paypal_onetime_status (
  id            VARCHAR(255) NOT NULL PRIMARY KEY,
  userId        BIGINT UNSIGNED NOT NULL,
  yen           INTEGER NOT NULL,
  credit        BIGINT NOT NULL,
  registeredAt  TIMESTAMP NOT NULL,
  FOREIGN KEY (userId)
    REFERENCES user_info (userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




--  twitter oauth
create table oauth_twitter_token (
  userId        BIGINT UNSIGNED NOT NULL PRIMARY KEY,
  token         VARCHAR(255) NOT NULL,
  secret        VARCHAR(255) NOT NULL,
  registeredAt  TIMESTAMP NOT NULL,
  FOREIGN KEY (userId)
    REFERENCES user_info (userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- make data
INSERT INTO roles(id, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles(id, role) VALUES (2, 'ROLE_USER');

INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
  VALUES ('0', 'apitore', NULL, 'read,write', 'authorization_code', NULL, 'ROLE_CLIENT', NULL, NULL, NULL, 'false');

-- make category
INSERT INTO categories (categoryId, category, visible)
  VALUES (1, 'text_analysis', true);
INSERT INTO categories (categoryId, category, visible)
  VALUES (2, 'machine_learning', true);
INSERT INTO categories (categoryId, category, visible)
  VALUES (3, 'computer_vision', true);
INSERT INTO categories (categoryId, category, visible)
  VALUES (4, 'utility', true);
INSERT INTO categories (categoryId, category, visible)
  VALUES (5, 'sentiment', true);
INSERT INTO categories (categoryId, category, visible)
  VALUES (6, 'deep_learning', true);
INSERT INTO categories (categoryId, category, visible)
  VALUES (7, 'face_detection', true);
INSERT INTO categories (categoryId, category, visible)
  VALUES (8, 'scraping', true);
INSERT INTO categories (categoryId, category, visible)
  VALUES (9, 'opencv', true);
INSERT INTO categories (categoryId, category, visible)
  VALUES (10, 'nlp', true);
INSERT INTO categories (categoryId, category, visible)
  VALUES (11, 'apache', true);

-- make api
INSERT INTO user_info (userId, username, displayname, thumbnail, homepage, description, open, isOrganization, registeredAt, updatedAt, lastLoginedAt)
  VALUES (1, 'Anonymous', 'Anonymous', true, null, 'Anonymous user/developer', true, true, now(), now(), now());
INSERT INTO user_info (userId, username, displayname, thumbnail, homepage, description, open, isOrganization, registeredAt, updatedAt, lastLoginedAt)
  VALUES (2, 'Apitore, Inc.', 'Apitore, Inc.', true, 'https://apitore.com/', 'Apitore, Inc.', true, true, now(), now(), now());
INSERT INTO user_attributes (userId) VALUES (1);
INSERT INTO user_attributes (userId) VALUES (2);

-- license
INSERT INTO licenses (licenseId, license)
  VALUES ( 1, 'The Unlicense');
INSERT INTO licenses (licenseId, license)
  VALUES ( 2, 'Apache License 2.0');
INSERT INTO licenses (licenseId, license)
  VALUES ( 3, 'GNU General Public License v3.0');
INSERT INTO licenses (licenseId, license)
  VALUES ( 4, 'MIT License');
INSERT INTO licenses (licenseId, license)
  VALUES ( 5, 'Artistic License 2.0');
INSERT INTO licenses (licenseId, license)
  VALUES ( 6, 'BSD 2-clause "Simplified" License');
INSERT INTO licenses (licenseId, license)
  VALUES ( 7, 'BSD 3-clause "New" or "Revised" License');
INSERT INTO licenses (licenseId, license)
  VALUES ( 8, 'Creative Commons Zero v1.0 Universal');
INSERT INTO licenses (licenseId, license)
  VALUES ( 9, 'Eclipse Public License 1.0');
INSERT INTO licenses (licenseId, license)
  VALUES (10, 'GNU Affero General Public License v3.0');
INSERT INTO licenses (licenseId, license)
  VALUES (11, 'GNU General Public License v2.0');
INSERT INTO licenses (licenseId, license)
  VALUES (12, 'GNU Lesser General Public License v2.1');
INSERT INTO licenses (licenseId, license)
  VALUES (13, 'GNU Lesser General Public License v3.0');
INSERT INTO licenses (licenseId, license)
  VALUES (14, 'ISC License');
INSERT INTO licenses (licenseId, license)
  VALUES (15, 'Mozilla Public License 2.0');
INSERT INTO licenses (licenseId, license)
  VALUES (16, 'Developer Defined License');

-- crawler
INSERT INTO update_data (id, lastUpdatedAt)
  VALUES (0, '2000-1-1');
INSERT INTO update_data (id, lastUpdatedAt)
  VALUES (1, '2000-1-1');
