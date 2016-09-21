(ns problems)

;List Replication
(def list-replication
  (fn [num lst]
    (apply concat (map (fn [x] (repeat num x)) lst))))

;Filter Array
(def filter-array
  (fn [delim lst]
    (filter #(< % delim) lst)))

;Filter out odd

(def filter-odd
  (fn [lst]
    (keep-indexed #(if (odd? %1) %2) lst)))