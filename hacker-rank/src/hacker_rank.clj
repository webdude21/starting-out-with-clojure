(ns hacker-rank
  (:gen-class)
  (:require [problems :refer :all]))

(defn -main [& args]
    (println (problems/listreplication 5 [1, 2, 3])))