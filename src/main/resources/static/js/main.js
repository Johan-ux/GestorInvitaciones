function deleteAsistente(asistenteId) {

    let inputValue = $('#sendInput-' + asistenteId).val();
    $.ajax({
        url: '/delete',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({id: inputValue}),
        success: function (response) {
            console.log('Response:', response);
            window.location.reload();
        },
        error: function (xhr, status, error) {
            console.error('Error:', error);
        }
    });
}