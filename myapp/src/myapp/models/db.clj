(ns myapp.models.db
  (:use korma.core
        [korma.db :only (defdb)])
  (:require [myapp.models.schema :as schema]))

(defdb db schema/db-spec)

(defentity blog)


(defn post-blog
  [name postdate]
  (insert blog 
    (values {
      :timestamp (new java.util.Date)
    	:name name 
      :post_date postdate 
        })))

(defn find-blog [name]
  (select blog 
    (fields :id)
    (where {:name [= name]})))

(defn update-blog
  [id name postdate]
  (update blog 
  	(set-fields
       {:timestamp (new java.util.Date)
        :name name
        :post_date postdate })
        (where {:id [= id]})
        ))

(defn update-blog-stat
  [id pageview vote share]
  (update blog 
    (set-fields
       {:timestamp (new java.util.Date)
        :pageview pageview 
        :vote vote
        :share share })
        (where {:id [= id]})
        ))

(defn list-blog []
  (select blog 
  	(order :post_date :ASC)))