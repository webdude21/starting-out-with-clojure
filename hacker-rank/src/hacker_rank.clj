(ns hacker-rank
  (:gen-class)
  (:require [problems :refer :all]))

(defn -main [& args]
    (def test-vector [1, 2, 3, 0, -14, 5, 4])
    (println (problems/list-replication 5 test-vector))
    (println (problems/filter-list 5 test-vector))
    (println (problems/filter-odd test-vector))
    (println (problems/item-replication 5))
    (println (problems/sum-odd test-vector))
    (println (problems/get-list-size test-vector))
    (println (problems/get-abs-values-list test-vector)))