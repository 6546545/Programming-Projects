using LanguageCreatorAI.Processors;

namespace LanguageCreatorAI.Grammar
{
    public class GrammarBuilder
    {
        public Grammar BuildGrammar(SyntaxRules syntaxRules)
        {
            return new Grammar
            {
                GrammarRules = syntaxRules.Rules
            };
        }
    }

    public class Grammar
    {
        public string[] GrammarRules { get; set; }
    }
}
