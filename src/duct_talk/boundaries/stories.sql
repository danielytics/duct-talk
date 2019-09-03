-- :name list-stories :?
-- :doc Retrieve list of all stories
select id, title, url, votes from stories; 

-- :name create-story! :!
-- :doc Create a new story submission
insert into stories (title, url) values (:title, :link);

-- :name upvote-story! :!
-- :doc Increment the vote count for a story
update stories set votes = votes + 1 where id = :id;
