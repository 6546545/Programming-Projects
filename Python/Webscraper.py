#Import "urlopen" from urllib package
from urllib.request import urlopen

#Define target url and call "urlopen"
url = "http://olympus.realpython.org/profiles/aphrodite"
page = urlopen(url)

#To test the url ->
print(page)

#Read HTML file and decode -> Store in html variable
html_data =  page.read()
html = html_data.decode("utf-8")

#Print to HTML code to terminal
print(html)