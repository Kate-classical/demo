gradlew build
docker build -t vilchyk/alfa-leasing-mail-send-api .
docker push vilchyk/alfa-leasing-mail-send-api:latest

http://templategenerator.alfaleasing.ru/swagger/index.html
https://www.browserling.com/tools/strip-slashes
newInvoiceForPay_text_v1
{
  "template_data": {
       "sum_doc": 5,
       "all_day": 3,
       "dateToPay": "5 января 2020 г.",
       "sum": 123.456,
       "link_to_lk": "https://cabinet-ui-dev.alfaleasing.ru/auth/login?utm_source=active-user&utm_medium=email&utm_campaign=payments-v1&utm_content=79258401311%7C7448087832",
       "link_to_feedback_statistics": "http://88.212.202.91:4444/alfa-leasing-mail-send-api/v1/email?template=12345678&phone=77777777777&inn=123"
    }
}
