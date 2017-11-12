
class StringBuilder {

	constructor() {
		this.array = [];
	}

	append(value) {
		if (value) {
			this.array.push(value);
		}
	}

	clear() {
		this.array.length = 1;
	}

	toString() {
		return this.array.join('');
	}
}