# Complicated Calculator
 A way to test out Java and improve my ability to create organized code.

## TODOs
- Add advanced math features
	- Trigonometric functions (sin, cos, tan) with degree/radian toggle
	- Log / ln, factorial, square root, nth root
	- Implement history of calculations and recall previous results
- Improve expression handling
	- Improve parentheses handling and show mismatched-parenthesis warnings
	- handle general warnings too
- Reliability & validation
	- Add input validation and user-friendly error messages for divide-by-zero and malformed expressions
	- Add unit tests for the expression parser/evaluator (Helper class)
- Developer tooling
	- Add CI (GitHub Actions) to run tests on push and PRs
	- Add code style/linting (Spotless / Checkstyle) and configure Gradle tasks
- Packaging & distribution
	- Provide a runnable JAR with a proper main class and a small launcher script
	- Create native installers using jpackage for macOS/Windows/Linux
- Accessibility & Internationalization
	- Add support for high-contrast mode and larger fonts
	- Externalize strings for i18n and add translations (en + one other)
- Nice-to-haves
	- Add theme support (light/dark) and persistent user preferences