<!DOCTYPE html>
<html lang="pl" xmlns:th="http:/www.thymeleaf.org">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous" />
    <!-- My Css -->
    <link rel="stylesheet" type="text/css" href="../css/main.css" />
    <title>CurrencyExchange - Tomasz Pazera</title>
</head>
<body>
<div class="container">
    <form method="post">
    <div class="row">
        <div class="col-sm">
            <h1>
                CurrencyExchange
                <small class="text-muted">by Tomasz Pazera</small>
            </h1>
        </div>
    </div>
    <div class="row">
        <div class="col-sm">
            <div id="errorMessage" style="dispaly:none;" class="alert alert-danger" role="alert">

                Proszę podać prawidłowe dane! (Wartość ${RequestParameters.fromRadio!""} jest niepoprawna)
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm">
            <div id="successMessage" style="dispaly:none;" class="alert alert-success" role="alert">
                Operacja wykonana pomyślnie!
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span id="fromValue" class="input-group-text">Kwota do przeliczenia</span>
                </div>
                <input name="fromValue" type="text" class="form-control" aria-label="Amount" value="${RequestParameters.fromValue!"100.0"}"/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm">
            <h2>Przelicz z:</h2>
            <div class="list fromlist">
                <#list currencylist as currency>
                    <div class="custom-control custom-radio">
                        <input type="radio" id="from${currency.code}" name="fromRadio" value="${currency.code}" class="custom-control-input">
                        <label class="custom-control-label" for="from${currency.code}">${currency.name} | ${currency.code}</label>
                    </div>
                </#list>
            </div>

        </div>
        <div class="col-sm">
            <h2>Przelicz na:</h2>
            <div class="list tolist">
                <#list currencylist as currency>
                    <div class="custom-control custom-radio">
                        <input type="radio" id="to${currency.code}" name="toRadio" value="${currency.code}" class="custom-control-input">
                        <label class="custom-control-label" for="to${currency.code}">${currency.name} | ${currency.code}</label>
                    </div>
                </#list>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <input id="convertButton" type="submit" class="btn btn-dark" value="Przelicz!" />
        </div>
        <div class="col-6">
            <input id="resetButton" class="btn btn-primary" type="reset" value="Reset" />
        </div>

    </div>
    </form>
    <div class="row">
        <div class="input-group">
            <input type="text" id="fromCurrencyValue" disabled class="form-control" value="${RequestParameters.fromValue!"100.0"}">
            <div class="input-group-prepend">
                <span class="input-group-text" id="fromCurrency">${RequestParameters.fromRadio!"PLN"}</span>
            </div>
            <input type="text" id="toCurrencyValue" disabled class="disabled form-control" value="${RequestParameters.outcome!"100.0"}">
            <div class="input-group-prepend">
                <span class="input-group-text" id="toCurrency">${RequestParameters.toRadio!"USD"}</span>
            </div>
        </div>
    </div>
</div>

<!-- Optional JavaScript -->
<script>
    console.log("LOL");
    if(document.getElementById("toCurrencyValue").value == "ERROR") {
        document.getElementById("errorMessage").style.display = "block";
        document.getElementById("successMessage").style.display = "none";
    } else {
        document.getElementById("errorMessage").style.display = "none";
        document.getElementById("successMessage").style.display = "block";
    }
</script>
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>