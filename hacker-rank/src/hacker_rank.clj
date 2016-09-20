(ns hacker-rank
  (:gen-class)
  (:require [problems :refer :all]))

(defn -main [& args]
    (println (problems/listreplication 5 [1, 2, 3]))
    (println (problems/filterArray 5 [1, 2, 3, 0, 14, 5, 4])))