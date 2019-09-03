-- :name list-comments :?
-- :doc Retrieve list of comments for a story
select id, comment, votes from comments
 where story_id = :story-id; 

-- :name add-comment! :! :1
-- :doc Add a new comment to a story
insert into comments (story_id, comment) values (:story-id, :comment);

-- :name upvote-comment! :!
-- :doc Increment the vote count for a comment
update comments set votes = votes + 1 where id = :id;

