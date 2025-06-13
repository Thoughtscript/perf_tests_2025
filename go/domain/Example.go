package domain

type Example struct {
	ID   string `json:id`
	Name string `json:name`
}

func GetExamples(outputChannel chan []Example) []Example {
	var examples []Example = make([]Example, 0)
	a := Example{"1", "a"}
	b := Example{"2", "b"}
	examples = append(examples, a, b)

	outputChannel <- examples
	return examples
}
