(slurp "Tweets.csv")
(with-open [rdr (clojure.java.io/reader "Tweets.csv")]
 (def data (reduce conj [] (line-seq rdr)) )
  ;;(println data)
 
)
  (def dataVector (into [] (partition 1 data)))
  ;;(println )
  (println (get dataVector 1))

