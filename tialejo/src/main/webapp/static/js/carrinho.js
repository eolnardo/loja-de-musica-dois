const removerProdutos = document.getElementsByClassName("remove");

for (var i = 0; i < removerProdutos.length; i++) {
    removerProdutos[i].addEventListener("click", function (event) {
        var buttonClicked = event.target;

        // Check if the target is the icon inside the button
        if (buttonClicked.tagName.toLowerCase() === 'i') {
            buttonClicked = buttonClicked.parentElement;
        }

        // Find the closest row to remove
        var row = buttonClicked.closest("tr");
        if (row) {
            row.remove();
            updateValor();
        }
    });
}

function updateValor(){
    let valorTotal = 0;
    const produtos = document.getElementsByClassName("linhaProduto");
    for (var i = 0; i <produtos.length; i++){
        //console.log(produtos[i])
        const precoProduto = produtos[i].getElementsByClassName("preçoProduto")[0].innerText.replace("R$", "").replace(",", ".");
        const quantidadeProduto = produtos[i].getElementsByClassName("qty")[0];

        valorTotal += precoProduto * quantidadeProduto
        console.log(valorTotal)
    }
    valorTotal = valorTotal.toFixed(2)
    document.getElementsByClassName("valorTotal").innerText = "R$" + total;
}
