## Synopsis

The **Paint Calculator** is a hypothetical project that calculates how many gallons of paint would be required to paint a number of rooms.

## Requirements

* Python 3 (not 2)
* Pip

## What we're looking for

* Install Python / Pip
* Run application
* Write tests against the application. They do not have to be in Python, and should be in whatever language you are most comfortable with.
- I've written tests in Java language using Rest Assured testing framework.
* Write a test plan for the application.  You are free to determine the structure and length of the test plan.
- I have a text file as part of this project called "Test Plan.txt" with my short and consice test plan, which outlines the test cases, scope, etc.
* You are allowed to change any of the source code as you see fit to make things easier for yourself. You are encouraged to fix any bugs you discover.
  - I fixed a bug where in run.py file, in calculate_feet method, the following line didn't have the right formula entered(((Length * 2) + (Width * 2)) * Height) and then modified it:
  return int(formatted_data['length']) * int(formatted_data['width']) * int(formatted_data['height'])
  TO 
  return int((formatted_data['length'] * 2) + int(formatted_data['width'] * 2)) * int(formatted_data['height'])
    
* Explain any problems you had while writing the tests, and what you did to make it easier. Pointing to localhost for the application is OK.
- There was a problem with validating the response as it came with HTML page rather than JSON datablock, which would've made the testing bit faster. I couldn't resolve this problem as it involves 
making many changes. I've never used Rest Assured testing framework or never used Java for writing test, so as I was learning, I was implementing the knowledge on writing the test cases.
* What would be the proper level of execution for tests of this application?  If this differs from the testing level you wrote tests for, please explain where they would be better suited.
- We could've done the execution of the test using UI automation framework but I wanted to try something different that I haven't had done previously in Java language, so I chose to
do api level testing instead of writing UI automated tests. Writing end-to-end test would've been better with UI automation, but I didn't have much time to add more on to the test project.

## Instructions

Because each applicant's code should be secret from one another, we should not submit it to the same repo.

1. Clone the repo (do not fork)
2. Create a new public repo on Github
3. Add the new repo as as a new remote
* `git remote add acme <url>`
4. Initialize the new repo with what is cloned
* `git push acme master`
5. Create a new branch off of master to put your changes on
6. Run the application locally
* `pip3 install -r requirements.txt`
* `python3 app/run.py`
7. Perform testing and debugging activities

## Submitting 

To make it easier on everybody, it's best if we use a PR to diff what work was completed.

1. Make any and all commits to your new branch and push the changes
* `git push acme <branch>`
2. Create a PR to your new repo
3. Make sure you include your test plan and any automated tests, as well as update this README to instruct someone on how to run the tests
4. Include any other text in a file - which tests would be suited for a different level of execution, or any problems encountered...etc
5. Send the link to the PR

## Running Tests

Write instructions for how a user executes the automated tests you created.
- Simply download the repo locally then open Eclipse IDE, and Open Project called Test1 from the file directory and then open JUNIT perspective and run the tests. 
