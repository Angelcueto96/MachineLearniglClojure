(slurp "test.csv")
(with-open [rdr (clojure.java.io/reader "test.csv")]
 (def data (reduce conj [] (line-seq rdr)) )
  ;;(println data)
 
)
;;Data Vector with lists in it
(def dataList (into [] (partition 1 data)))
  ;;(println )
;;Data Vector with Vectors in it
(def dataVector (mapv vec dataList))
(println (get dataVector 1))


;;Recives a vector with a single string and returns a vector with multiple data
(defn splitString[_vector] 
  (def temp (get _vector 0))
  (def tempVector (clojure.string/split (apply str temp) #","))
  
  
)

(def a
  (into []
    (map ( fn[data]
          
          (splitString data)

          (def add1 (assoc data 0  ( get tempVector 0)) )     
          (def add2 (conj add1 (get tempVector 1)) )
          (conj add2 (get tempVector 2))
        
        )  
      dataVector
    )
  )
)
(println a)