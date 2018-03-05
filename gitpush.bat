set var=""
for %%i in (%*) do (
%var+=%%~i
%var+=" "
)
git add *
:: git commit -m "%var%"
:: git push origin development
