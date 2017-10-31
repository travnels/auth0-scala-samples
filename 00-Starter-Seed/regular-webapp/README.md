# Auth0 + Play 2 Scala Regular WebApp Seed

This is the seed project you need to use if you're going to create regular Webapp with Scala and Play2. If you want to create a Play Scala API to use with your SPA or mobile app, please check [this other seed project](TODO://)

Check the [Play 2 Scala Quickstart](https://auth0.com/docs/quickstart/webapp/scala) to better understand this sample.

#Running the example

In order to run the example you need to have `sbt` installed.

Rename `.env.example` to `.env` and set the ClientSecret, ClientId, CallbackURL, Domain and Audience from Auth0 in the `.env` file. Just look for the placeholders and fill them with the right information

__Note:__ If you are not implementing any API, leave `AUTH0_AUDIENCE` empty, will be set with `https://AUTH0_DOMAIN/userinfo`.

````bash
# .env file

AUTH0_CLIENT_ID={CLIENT_ID}
AUTH0_DOMAIN={DOMAIN}
AUTH0_CLIENT_SECRET={CLIENT_SECRET}
AUTH0_CALLBACK_URL="http://localhost:9000/callback"
AUTH0_AUDIENCE={AUDIENCE}
````

Register `http://localhost:9000/callback` as `Allowed Callback URLs` and `http://localhost:9000`
as `Allowed Logout URLs` in your app settings.

Finally, run `sbt run` to start the app and try calling [http://localhost:9000/](http://localhost:9000/)

## Running the example with docker

In order to run the example with docker you need to have `docker` installed.

You also need to set the environment variables as explained [previously](#running-the-example).

Execute in command line `sh exec.sh` to run the Docker in Linux, or `.\exec.ps1` to run the Docker in Windows.

## What is Auth0?

Auth0 helps you to:

* Add authentication with [multiple authentication sources](https://docs.auth0.com/identityproviders), either social like **Google, Facebook, Microsoft Account, LinkedIn, GitHub, Twitter, Box, Salesforce, amont others**, or enterprise identity systems like **Windows Azure AD, Google Apps, Active Directory, ADFS or any SAML Identity Provider**.
* Add authentication through more traditional **[username/password databases](https://docs.auth0.com/mysql-connection-tutorial)**.
* Add support for **[linking different user accounts](https://docs.auth0.com/link-accounts)** with the same user.
* Support for generating signed [Json Web Tokens](https://docs.auth0.com/jwt) to call your APIs and **flow the user identity** securely.
* Analytics of how, when and where users are logging in.
* Pull data from other sources and add it to the user profile, through [JavaScript rules](https://docs.auth0.com/rules).

## Create a free Auth0 account

1. Go to [Auth0](https://auth0.com/signup) and click Sign Up.
2. Use Google, GitHub or Microsoft Account to login.

## Issue Reporting

If you have found a bug or if you have a feature request, please report them at this repository issues section. Please do not report security vulnerabilities on the public GitHub issue tracker. The [Responsible Disclosure Program](https://auth0.com/whitehat) details the procedure for disclosing security issues.

## Author

[Auth0](https://auth0.com)

## License

This project is licensed under the MIT license. See the [LICENSE](LICENSE.txt) file for more info.
