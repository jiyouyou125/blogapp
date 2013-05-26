(defproject myapp "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [lib-noir "0.6.0"]
                 [compojure "1.1.5"]
                 [ring-server "0.2.7"]
                 [clabango "0.5"]
                 [com.taoensso/timbre "1.5.2"]
                 [com.taoensso/tower "1.5.1"]
                 [markdown-clj "0.9.21"]
                 [com.h2database/h2 "1.3.170"]
                 [korma "0.3.0-RC5"]
                 ]
  :plugins [[lein-ring "0.8.3"]]
  :ring {:handler myapp.handler/war-handler
         :init    myapp.handler/init
         :destroy myapp.handler/destroy}
  :profiles
  {:production {:ring {:open-browser? false
                       :stacktraces?  false
                       :auto-reload?  false}}
   :dev {:dependencies [[ring-mock "0.1.3"]
                        [ring/ring-devel "1.1.8"]]}}
  :min-lein-version "2.0.0")