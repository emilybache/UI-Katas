
You have inherited this code, (imagine it is part of a larger system). Your task is to improve the validation for each of the three options:

- Verify that all URLs point to pages on this site: http://example.com.
- Ensure the text doesn't include the word "Problem", and if it does suggest to change it to "Issue".
- Validate the HTML is valid, and the text of the body similarly doesn't include the word "Problem".

In order to do this, you'll want to get the existing validation code under test. Try to write unit tests for the code. I think you'll find this hard, and will want to refactor it. However, first do try to get the code under test while making as few changes as possible. It's dangerous to make changes without any tests.

- Why is it difficult to write unit tests for this code? 
- Does this code disobey SOLID principles? Which ones?

When you're happy you can refactor and your tests will catch any mistakes you make, refactor the code add add the new features, (or as many of them as you have time for in your dojo!).

- Does the your refactored code better obey SOLID principles? Which ones?
- What is the code coverage of your unit tests? How will you test any remaining code?

This Kata was originally designed using Java Swing by Brett Schuchert and is presented in his article ["Legacy Refactoring: Improving Testability of UI Code"](http://schuchert.wikispaces.com/tdd.Refactoring.UiExample). I suggest you have a go at the exercise yourself before you read the article.
