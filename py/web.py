from flask import flask


web = Flask(__name__)
if __name__ == "__main__":
    web.run(debug= True)