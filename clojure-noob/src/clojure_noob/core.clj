(ns clojure_noob.core
  (:gen-class))

(defn -main
  [& args]


  ;; curryable sum function
  (defn sum
    [x]
      (fn [y] (+ x y))
    )

  (defn avarage
    [numbers]
      (/ (apply + numbers) (count numbers)))

  ;; curried version of sum with 2
  (def sumWithTwo (sum 2))

  (def someNumbers [60 80 100 400])

  (printf "Average of %s is %d%n" someNumbers (avarage someNumbers))
  (println (map sumWithTwo [1 3 4 5 6]))
)