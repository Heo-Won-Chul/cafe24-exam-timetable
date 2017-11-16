const oDefaultError = (oRequest, nStatus, oError) => {
	alert(oRequest.responseJSON === undefined ? '오류가 발생했습니다' : oRequest.responseJSON.message);
};
const nDefaultTimeout = 300;
const bDefaultCache = false;

class welAjax {

	static getCall(sUrl, oSuccess, oError = oDefaultError, nTimeout = nDefaultTimeout, bCache = bDefaultCache) {
		$.ajax({
			type: 'get',
			url: sUrl,
			success: oSuccess,
			error: oError,
			timeout: nTimeout,
			cache: bCache
		});
	}

	static postCall(sUrl, oData, oSuccess, oError = oDefaultError, nTimeout = nDefaultTimeout, bCache = bDefaultCache) {
		$.ajax({
			type: 'post',
			url: sUrl,
			contentType: 'application/json',
			dataType: 'json',
			data: JSON.stringify(oData),
			success: oSuccess,
			error: oError,
			timeout: nTimeout,
			cache: bCache
		});
	}

	static putCall(sUrl, oData, oSuccess, oError = oDefaultError, nTimeout = nDefaultTimeout, bCache = bDefaultCache) {
		$.ajax({
			type: 'put',
			url: sUrl,
			contentType: 'application/json',
			dataType: 'json',
			data: JSON.stringify(oData),
			success: oSuccess,
			error: oError,
			timeout: nTimeout,
			cache: bCache
		});
	}

	static deleteCall(sUrl, oSuccess, oError = oDefaultError, nTimeout = nDefaultTimeout, bCache = bDefaultCache) {
		$.ajax({
			type: 'delete',
			url: sUrl,
			success: oSuccess,
			error: oError,
			timeout: nTimeout,
			cache: bCache
		});
	}
}