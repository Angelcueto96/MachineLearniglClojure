
(slurp "googleplaystore.csv")
(with-open [rdr (clojure.java.io/reader "googleplaystore.csv")]
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
          (def add0 (assoc data 0  ( get tempVector 0)) ) 
          ;;conj to append data    
          (def add1 (conj add0 (get tempVector 1)))
          (def add2 (conj add1 (get tempVector 2)))
          (def add3 (conj add2 (get tempVector 3)))
          (def add4 (conj add3 (get tempVector 4)))
          (def add5 (conj add4 (get tempVector 5)))
          (def add6 (conj add5 (get tempVector 6)))
          (def add7 (conj add6 (get tempVector 7)))
          (def add8 (conj add7 (get tempVector 8)))
          (def add9 (conj add8 (get tempVector 9)))
          (def add10 (conj add9 (get tempVector 10)))
          (def add11 (conj add10 (get tempVector 11)))
          ;;need to finish withour def statement
          (conj add11 (get tempVector 12 ))
        
        )  
      dataVector
    )
  )
)
(doseq [n dataStructure]
 (println n)
)

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
;;(println positive)


(def negative 
  (into[]
    (filter ( fn [data]
            (def sentiment (get data 0))
            (= sentiment "negative")
            ) dataStructure)
  )
)
;;(println negative)

(def neutral
  (into[]
    (filter ( fn [data]
            (def sentiment (get data 0))
            (= sentiment "neutral")
            ) dataStructure)
  )
)  

;;(println neutral)


