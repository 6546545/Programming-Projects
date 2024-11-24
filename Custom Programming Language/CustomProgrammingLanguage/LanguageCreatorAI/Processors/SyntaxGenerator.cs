namespace LanguageCreatorAI.Processors
{
    public class SyntaxGenerator
    {
        public SyntaxRules GenerateSyntax(SemanticStructure structure)
        {
            return new SyntaxRules
            {
                Rules = new[] { "def", "class", "if", "while", "for" }
            };
        }
    }

    public class SyntaxRules
    {
        public string[] Rules { get; set; }
    }
}
