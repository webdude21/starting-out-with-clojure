(ns problems)

;List Replication
(def list-replication
  (fn [num lst]
    (apply concat (map (fn [x] (repeat num x)) lst))))

;Filter list
(def filter-list
  (fn [delim lst]
    (filter #(< % delim) lst)))

;Filter out odd
(def filter-odd
  (fn [lst]
    (keep-indexed #(if (odd? %1) %2) lst)))

;List of n elements
(def item-replication
  (fn [n]
    (repeat n n)))

;List reverse
(def list-reverse
  (fn [lst]
    (reverse lst)))

;Sum of odd elements
(def sum-odd
  (fn [lst]
    (reduce + (filter odd? lst))))