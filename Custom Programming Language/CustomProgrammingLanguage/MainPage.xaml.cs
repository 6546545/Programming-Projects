using Microsoft.Maui.Controls;
using LanguageCreatorAI.Processors;
using LanguageCreatorAI.Grammar;

namespace LanguageCreatorAI
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

        private void OnGenerateLanguageClicked(object sender, EventArgs e)
        {
            if (LanguagePicker.SelectedItem == null || string.IsNullOrWhiteSpace(FeaturesEditor.Text))
            {
                DisplayAlert("Error", "Please select a language and specify features.", "OK");
                return;
            }

            string spokenLanguage = LanguagePicker.SelectedItem.ToString();
            string features = FeaturesEditor.Text;

            try
            {
                // Backend logic integration
                var semanticParser = new SemanticParser();
                var syntaxGenerator = new SyntaxGenerator();
                var grammarBuilder = new GrammarBuilder();

                var semanticStructure = semanticParser.Parse(features);
                var syntaxRules = syntaxGenerator.GenerateSyntax(semanticStructure);
                var grammar = grammarBuilder.BuildGrammar(syntaxRules);

                // Display results
                SyntaxListView.ItemsSource = grammar.GrammarRules;
            }
            catch (Exception ex)
            {
                DisplayAlert("Error", $"An error occurred: {ex.Message}", "OK");
            }
        }
    }
}
