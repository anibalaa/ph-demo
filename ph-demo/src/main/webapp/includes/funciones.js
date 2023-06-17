function confirmar() {
    var res = false;
    if (confirm('Estás seguro de eliminar esta url?'))
        res = true;
    else
        res = false;
    return res;
}
