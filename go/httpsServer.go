package main

import (
	h "goserver/handlers"
	"log"
	"net/http"
)

func main() {
	// Context path not function registration name
	http.HandleFunc("/api/example/all", h.GetExamples)

	// TLS
	port := ":9999"
	log.Println("Listening on port", port)
	go log.Fatal(http.ListenAndServeTLS(port, "certificate.pem", "key.pem", nil))
}
