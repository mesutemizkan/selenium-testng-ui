# 1) Clone the project repo
Run the following command from terminal

    git clone https://github.com/mesutemizkan/selenium-testng-ui.git

# 2) Install 'maven'
Use 'homebrew' to install 'maven'
    
a) Below command will install homebrew:

    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"


b) Run these two commands in your terminal to add Homebrew to your PATH (optional):

    echo 'eval "$(/opt/homebrew/bin/brew shellenv)"' >> /Users/<profile>/.zprofile
    
    eval "$(/opt/homebrew/bin/brew shellenv)"

c) Install maven
    
    brew install maven


# 4) Run the test

a) Go in to root directory and run the following command (where .pom file located)

   mvn -Dtest=DiscountCodeTests.java test

b) You should see the following log:

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 109.4 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:51 min
[INFO] Finished at: 2022-09-07T17:26:38-05:00
[INFO] ------------------------------------------------------------------------

