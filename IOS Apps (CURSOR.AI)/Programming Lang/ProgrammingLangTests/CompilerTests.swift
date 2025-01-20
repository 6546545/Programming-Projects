import XCTest
@testable import ProgrammingLang

final class CompilerTests: XCTestCase {
    var compiler: Compiler!
    
    override func setUp() {
        super.setUp()
        let syntax = LanguageGenerator.GeneratedSyntax(
            keywords: ["var": "variable", "let": "constant", "if": "if", "else": "else"],
            operators: ["+": "plus", "-": "minus", "*": "times", "/": "divide"],
            patterns: [:],
            precedenceRules: ["+": 1, "-": 1, "*": 2, "/": 2]
        )
        compiler = Compiler(syntax: syntax)
    }
    
    func testBasicCompilation() throws {
        let source = """
        var x = 42
        var y = x + 8
        """
        
        let result = try compiler.compile(source)
        XCTAssertFalse(result.isEmpty)
    }
    
    func testInvalidSyntax() {
        let source = "var 123invalid = 42"
        
        XCTAssertThrowsError(try compiler.compile(source)) { error in
            XCTAssertTrue(error is AppError)
        }
    }
} 