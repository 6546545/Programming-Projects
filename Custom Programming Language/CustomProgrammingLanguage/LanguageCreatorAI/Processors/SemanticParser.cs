namespace LanguageCreatorAI.Processors
{
    public class SemanticParser
    {
        public SemanticStructure Parse(string input)
        {
            return new SemanticStructure
            {
                BaseLanguage = "English",
                Features = input.Split(", ")
            };
        }
    }

    public class SemanticStructure
    {
        public string BaseLanguage { get; set; }
        public string[] Features { get; set; }
    }
}
