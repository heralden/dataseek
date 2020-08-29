PATH := node_modules/.bin:$(PATH)

dev: css
	clojure -A:dev -m figwheel.main -b dev

repl: css
	clojure -A:dev -A:repl

test:
	clojure -A:test

prod: export NODE_ENV := production
prod: css
	clojure -A:dev -m figwheel.main --build-once prod

node_modules/.bin/tailwindcss:
	npm install

resources/public/css/style.css: node_modules/.bin/tailwindcss
	tailwindcss build src/style.css -o resources/public/css/style.css

css: node_modules/.bin/tailwindcss resources/public/css/style.css

.PHONY: dev repl test prod css
