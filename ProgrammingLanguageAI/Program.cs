using ProgrammingLanguageAI.LanguageProcessor;
using ProgrammingLanguageAI.Grammar;
using ProgrammingLanguageAI.IR;
using ProgrammingLanguageAI.Compiler;

namespace ProgrammingLanguageAI
{
    class Program
    {
        static void Main(string[] args){
            var userPrefs = UserInterface.GetUserPreferences();

            var semanticPars = new SemanticParser.Parse(userPreferences);
        }
    }
}