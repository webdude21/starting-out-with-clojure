(defproject clojure-noob "0.1.0-SNAPSHOT"
  :description "Hacker Rank with Clojure"
  :url "https://github.com/webdude21/starting-out-with-clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot hacker-rank
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
