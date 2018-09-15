
(slurp "test.csv")
(with-open [rdr (clojure.java.io/reader "test.csv")]
 (def data (reduce conj [] (line-seq rdr)) )
  ;;(println data)
 
)
;;Data Vector with lists in it

(def dataList (into [] (partition 1  data)))
  ;;(println )
;;Data Vector with Vectors in it
(def dataVector (mapv vec dataList))
;;(println (get dataVector 1))




;;Recives a vector with a single string and returns a vector with multiple data
(defn splitString[_vector] 
  (def temp (get _vector 0))
  (def tempVector (clojure.string/split (apply str temp) #","))
  
  
)

(def dataStructure
  (into []
    (map ( fn[data]
          (splitString data)
          ;;decide which filds to add
          ;;assoc to replace string value
          (def add1 (assoc data 0  ( get tempVector 1)) ) 
          ;;conj to append data    
          (def add2 (conj add1 (get tempVector 5)) )
          ;;need to finish withour def statement
          (conj add2 (get tempVector 12))
        
        )  
      dataVector
    )
  )
)
;;(doseq [n dataStructure]
 ;; (println n)
;;)

(defn compare[tupple]
    
    (def sentiment (get tupple 0))
    (= sentiment "positive")
    ;;(println sentiment)
  
    
)
(def positive 
  (into[]
    (filter ( fn [data]
            (def sentiment (get data 0))
            (= sentiment "positive")
            ) dataStructure)
  )
)
(println positive)


(def negative 
  (into[]
    (filter ( fn [data]
            (def sentiment (get data 0))
            (= sentiment "negative")
            ) dataStructure)
  )
)
(println negative)

(def neutral
  (into[]
    (filter ( fn [data]
            (def sentiment (get data 0))
            (= sentiment "neutral")
            ) dataStructure)
  )
)  

(println neutral)


