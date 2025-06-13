package handlers

import (
	"encoding/json"
	e "goserver/domain"
	"net/http"
)

var outputChannel = make(chan []e.Example)

func GetExamples(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")

	if r.Method == http.MethodGet {
		w.WriteHeader(http.StatusOK)

		//outputChannel := make(chan []e.Example)

		go e.GetExamples(outputChannel)

		results := <-outputChannel
		// close(outputChannel)

		err := json.NewEncoder(w).Encode(results)
		if err != nil {
			w.WriteHeader(http.StatusBadRequest)
		}
	} else {
		w.WriteHeader(http.StatusMethodNotAllowed)
	}
}
