(ns hacker-rank
  (:gen-class)
  (:require [problems :refer :all]))

(defn -main [& args]
    (def test-array [1, 2, 3, 0, 14, 5, 4])

    (println (problems/list-replication 5 test-array))
    (println (problems/filter-array 5 test-array))
    (println (problems/filter-odd test-array)))